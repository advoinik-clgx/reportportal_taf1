Report Portal test automation project

### To run tests:

`gradle clean test`

Supported arguments:

* **rp.endpoint** - url to run tests against;
* **web_driver** - WebDriver name (_chrome_ or _firefox_, if not provided, _chrome_ will run)

### !!!!!

`rp_api_password` and `rp_api_user=ui` environment variables should be available for API user for Bearer token generation

E.g.:

```shell
gradle clean test -Drp.endpoint="http://localhost:8080/" -Ddriver="chrome"
```

### To run Allure report:

```shell
gradle allureServe
```
