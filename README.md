# complete-microservices

Stock Exchange სისტემის იმიტაცია:
* წინასწარ დარეგისტრირებული კომპანიების ქციების ფასთა ცვალებადობა გენერირდება date-stream სერვისით, მონაცემები ინახება ![postgreSQL](https://cdn-icons-png.flaticon.com/512/5968/5968342.png) postgreSQL მონაცემთა ბაზაში. <img src="https://cdn-icons-png.flaticon.com/512/5968/5968342.png" width="50" />
მასშტაბირება ხდება apache kafka-ს გამოყენებით.
* ცვლილებები ცოცხალ რეჟიმში გადაეცემა ui-service -ს და RabbitMQ-ს გამოყენებით და გამოაქვს ეკრანზე
