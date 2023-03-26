# complete-microservices

Stock Exchange სისტემის იმიტაცია:
* წინასწარ დარეგისტრირებული კომპანიების აქციების ფასთა ცვალებადობა გენერირდება date-stream სერვისით, მონაცემები ინახება <img src="https://cdn-icons-png.flaticon.com/512/5968/5968342.png" width="20" /> **PostgreSQL** მონაცემთა ბაზაში. 
მასშტაბირება ხდება <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Apache_kafka-icon.svg/1200px-Apache_kafka-icon.svg.png" height="25" /> **Apache Kafka**-ს გამოყენებით.
* ცვლილებები ცოცხალ რეჟიმში გადაეცემა ui-service -ს და <img src="https://www.vectorlogo.zone/logos/rabbitmq/rabbitmq-ar21.png" height="30" /> **RabbitMQ**-ს გამოყენებით და გამოაქვს ეკრანზე

---------------------
<img src="https://flagcdn.com/h20/se.png" height="15" /> [Klicka här för att se en beskrivning på svenska](README-SE.md)
