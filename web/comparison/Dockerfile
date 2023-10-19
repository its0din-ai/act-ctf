# Use the official PHP 7 image as the base image
FROM php:7-apache

# Copy your auth.php file into the /var/www/html directory
COPY ./src/auth.php /var/www/html/
COPY ./src/727f8c95dab6ddf2aa5b6ab53ceb7523276f1f80.php /var/www/html/

# Set the working directory to /var/www/html
WORKDIR /var/www/html

# Expose port 80 for HTTP
EXPOSE 80

# Start the Apache web server
CMD ["apache2-foreground"]