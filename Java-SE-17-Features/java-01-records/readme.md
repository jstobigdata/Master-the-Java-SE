- Records in JDK-17 are implicitly final
- Records cannot extend classes, but can implement interfaces
- Superclass for records is java.lang.Record
- Ideal fit for Domain Objects =! can not be used in JPA Entity classes. Cause this is immutable.
- You can use them as a readonly objects when you have multi layered applications.
- Best fit for data transfer objects