const express = require('express');
const jwt = require('jsonwebtoken');
const expressHandlebars = require('express-handlebars');
const cookieParser = require('cookie-parser');
const app = express();
app.engine('handlebars', expressHandlebars({
    defaultLayout: 'main',
    extname: '.handlebars'
}));
app.set('view engine', 'handlebars');
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
const secretKey = 'anon-cyber-team';
const users = [
    { id: 1, username: 'admin', password: ';-0iu*54CDle<T|=8IULfsq|V=6BO^2?6Db;<36~z[+Q72vP;l', role: 'admin' },
    { id: 2, username: 'guest', password: 'guest', role: 'user' }
];
function authenticateUser(req, res, next) {
    const { username, password } = req.body;
    const user = users.find(u => u.username === username);
    if (!user || user.password !== password) {
        return res.redirect('/invalid');
    }
    const token = jwt.sign({ user: user.username, role: user.role }, secretKey);
    res.cookie('token', token);
    res.redirect('/dashboard');
}
function checkTokenAndRole(req, res, next) {
    const token = req.cookies.token;
    if (!token) {
        return res.redirect('/login');
    }
    jwt.verify(token, secretKey, (err, user) => {
        if (err) {
            return res.redirect('/login');
        }
        req.user = user;
        next();
    });
}
app.get('/', (req, res) => {
    res.redirect('/login')
});
app.get('/invalid', (req, res) => {
    res.render('error')
});
app.get('/login', (req, res) => {
    const token = req.cookies.token;
    const notLoggedIn = !token;
    res.render('login', { notLoggedIn });
});
app.post('/login', authenticateUser);
app.get('/dashboard', checkTokenAndRole, (req, res) => {
    const user = req.user;
    if (user.role === 'admin') {
        res.render('dashboard', { isAdmin: true });
    } else {
        res.render('dashboard', { isAdmin: false });
    }
});
app.get('/logout', (req, res) => {
    res.clearCookie('token');
    res.redirect('/login');
});
const port = process.env.PORT || 3000;
app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});