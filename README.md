## Code Challenge

Challenge: https://gist.github.com/N3mezis/e058340930a385d4d4aac513cd0f1c1a#file-codingchallenge-md

## How to run
Run alle the unit tests with maven
```
mvn clean test
```
Run tests related to basked tasks:

````
mvn test -Dtest="ShoppingBasketTest"
````

Run tests related to sales deals:
```
mvn test -Dtest="SalesDealsTest" 
```
## Further Comments
- As usual and recommended I decided to use the `BigDecimal` class for monetary values.
- The `SalesDeals` are specified by an functional interface and can be implemented like in
my provided sample.

##### Author: 
Simon-Justus Wimmer