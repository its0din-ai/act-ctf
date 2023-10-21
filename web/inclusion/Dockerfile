FROM php:7.4-apache
WORKDIR /var/www/html
COPY flag.txt /flag.txt
COPY src/ /var/www/html/
RUN chmod 444 /flag.txt
RUN chown root:root /flag.txt
EXPOSE 80
CMD ["apache2-foreground"]