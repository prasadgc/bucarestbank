# bucarestbank
# This is a demo online banking application that illustrates the use of the BUCAREST architectural style.
# It uses the JavaScript frameworks Alpine.js and HTMX on the front-end, along with Bootstrap CSS for layout and styling.
# The back-end uses Spring Boot with the Thymeleaf template engine.

# Run the app, then point your browser at localhost:8081 to see the online banking screen.
# Also open the browser console to see the HTTP requests and responses.

# Doing a transfer or making a payment is a POST request.
# The HTTP response will have two fine-grained application headers 
# "Hx-Trigger : account.currentBalance"
# "Hx-Trigger : transactions"
# This then triggers two of the three visual components on the page to refresh themselves through GET requests.
