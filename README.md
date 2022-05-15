# prueba4sanitas
Prueba 4 para sanitas

Micro servicio Calculadora

Este servicio realiza una serie de cálculos básicos, suma y resta de 2 elementos

Para arrancar el servicio ejecutar mvnw spring-boot:run o manualmente con mvnw package y 
java -jar target/calculadora-0.0.1-SNAPSHOT.jar

Adicionalmente hay un endpoint de Swagger con la descripción de las operaciones que esta (una vez arrancada la
aplicación) en http://localhost:8080/swagger-ui/index.html

Los enpoints implementados actualmente son:

POST http://localhost:8080/calculadora/suma
    Operación de sumar
    Consume un application/json  con un objeto con la clave términos y dentro un array de 2 elementos con números
        {
            "terminos": [1,2]
        }
    Produce un application/json con un objeto con el resultado
        {
            "resultado": 3
        }
    
POST http://localhost:8080/calculadora/resta
    Operación de restar
    Consume un application/json  con un objeto con la clave términos y dentro un array de 2 elementos con números, el
    orden en este caso es importante, ya que resta los números en el orden dentro del array
        {
            "terminos": [3,2]
        }
    Produce un application/json con un objeto con el resultado
        {
            "resultado": 1
        }
    
GET http://localhost:8080/actuator/health
    Servicio para comprobar si el servicio esta vivo
    No consume nada
    Produce un application/json con información si esta correcto
        {"status":"UP"}