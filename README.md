

# Database endpoint:
     - here can be queried h2 datatabase
    http://localhost:8088/h2-console/
    
# Swagger:
        - here we can sent Rest requests
    http://localhost:8088/swagger-ui.html#
    
# Example insert/update query body:
        - Will insert 2 clients into database
    [
        {
          "clientId": 1,
          "addressByActualLiving": "string",
          "areaOfBurn": "string",
          "burnDate": "17-03-2001",
          "citiesByActualLiving": [
            "string1",
            "string2"
          ],
          "citizenship": [
            "string1",
            "string2"
          ],
          "disability": [
            "string1",
            "string2"
          ],
          "familyStatus": [
            "string1",
            "string2"
          ],
          "fartherName": "string",
          "gender": true,
          "homePhone": "8017-222-11-22",
          "identityCardDto": {
            "identityCardId": 1,
            "addressByIdentityCard": "string",
            "citiesByIdentityCard": [
                "string1",
                "string2"
            ],
            "dateOfIdentityCardReceiving": "19-05-2001",
            "identityCardNumber": "14357668",
            "identityCardSupplier": "string",
            "identityCardVersion": "3564765"
          },
          "lastName": "string",
          "mobilePhone": "+375(29)913-05-38",
          "monthIncome": 34.4,
          "name": "string",
          "retiree": true
        },
        {
          "clientId": 2,
          "addressByActualLiving": "string",
          "areaOfBurn": "string",
          "burnDate": "17-03-2001",
          "citiesByActualLiving": [
            "string1",
            "string2"
          ],
          "citizenship": [
            "string1",
            "string2"
          ],
          "disability": [
            "string1",
            "string2"
          ],
          "familyStatus": [
            "string1",
            "string2"
          ],
          "fartherName": "string",
          "gender": true,
          "homePhone": "8017-222-11-22",
          "identityCardDto": {
            "identityCardId": 1,
            "addressByIdentityCard": "string",
            "citiesByIdentityCard": [
                "string1",
                "string2"
            ],
            "dateOfIdentityCardReceiving": "19-05-2001",
            "identityCardNumber": "14357668",
            "identityCardSupplier": "string",
            "identityCardVersion": "3564765"
          },
          "lastName": "string",
          "mobilePhone": "+375(29)913-05-38",
          "monthIncome": 34.4,
          "name": "string",
          "retiree": true
        }
    ]