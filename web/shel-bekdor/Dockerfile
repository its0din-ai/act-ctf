FROM php:7.4-apache

COPY ./src/index.php /var/www/html/
COPY ./fl49.txt /fl49.txt

RUN chown root:root /fl49.txt
RUN chmod 444 /fl49.txt

EXPOSE 3000
CMD ["php", "-S", "0.0.0.0:3000", "-t", "/var/www/html/"]