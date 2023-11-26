# Fortune Cookies API

---

**v1.0.0.Beta**

### Description

---

This is a simple API that performs the following services:

- accepts a [fortune](src/main/kotlin/com/hunteryavitz/fortunecookiesapi/Fortune.kt) object and saves it to a
  [local file](src/main/resources/SOMEONE.txt) as a `list` given the name of a
  [recipient](src/main/kotlin/com/hunteryavitz/fortunecookiesapi/RECIPIENT.kt).
- returns a `list` of [fortune](src/main/kotlin/com/hunteryavitz/fortunecookiesapi/Fortune.kt) objects from a saved
  [local file](src/main/resources/SOMEONE.txt) given the name of a
  [recipient](src/main/kotlin/com/hunteryavitz/fortunecookiesapi/RECIPIENT.kt).

### Setup

---

Simply clone this repository and configure the `application.properties` file to contain the path to the directory where
the local files will be stored. The default is `src/main/resources/`.

Next run the following commands:

**Run Unit Tests**

```shell
./mvnw test
```

**Run Application**

```shell
./mvnw spring-boot:run
```

### Usage

---

GET http://localhost:8080/fortunes/{{recipient}}

POST http://localhost:8080/fortune/{{recipient}}

```json
{
  "message": "You will be hungry again in one hour.",
  "author": "Hunger"
}
```

### Future Improvements

---

In the near future I'd like to couple this API with the mobile client.
