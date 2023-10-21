FROM php:7-apache

COPY ./src/auth.php /var/www/html/
COPY ./src/727f8c95dab6ddf2aa5b6ab53ceb7523276f1f80.php /var/www/html/

WORKDIR /var/www/html

EXPOSE 80
CMD ["apache2-foreground"]