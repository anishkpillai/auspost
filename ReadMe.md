# Prerequisites to run

JDK and Apache Maven should be installed and open as Maven Project

## Running the tests

Use the **maven** command or use the **cucumber feature runner** from IntelliJ or **RunCukesTest**

```bash
mvn clean install
mvn clean test -Dcucumber.options="--tags @SPECIAL_SIZE"
mvn clean test -Dcucumber.options="--tags @POSTAGE_CALCULATE"

```

