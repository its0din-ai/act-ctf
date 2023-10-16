FROM php:7.4-apache

COPY ./src/index.php /var/www/html/
COPY ./fl49.txt /fl49.txt

RUN chown root:root /fl49.txt
RUN chmod 444 /fl49.txt

EXPOSE 13372
CMD ["php", "-S", "0.0.0.0:13372", "-t", "/var/www/html/"]