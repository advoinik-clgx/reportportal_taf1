Report Portal test automation project

### To run tests:

`gradle clean test`

Supported arguments:

* **rp_endpoint** - url to run tests against;
* **web_driver** - WebDriver name (_chrome_ or _firefox_, if not provided, _chrome_ will run) 

### !!!!!

`api_token` environment variable have to be available for making calls to Report Portal API client.

E.g.:

```shell
gradle clean test -Drp_endpoint="http://localhost:8080/" -Ddriver="chrome"
```

### To run Allure report:

```shell
gradle allureServe
```
