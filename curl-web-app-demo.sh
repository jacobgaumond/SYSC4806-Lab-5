# Create an address book
curl -X POST http://localhost:8080/addressBooks \
     -H "Content-Type: application/json" \
     -d '{}'

# Create a buddy
curl -X POST http://localhost:8080/buddyInfoes \
     -H "Content-Type: application/json" \
     -d '{"name": "Homer", "phoneNumber": "1234512345"}'

# Add new buddy to the address book
curl -X POST http://localhost:8080/addressBooks/1/buddyList \
     -H "Content-Type: text/uri-list" \
     -d "http://localhost:8080/buddyInfoes/1"
