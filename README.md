🗄️ Java JDBC with MySQL

Learning how Java connects to a database using JDBC, one day at a time. 🚀

Day 1: JDBC basics (Day2.java)

Connected Java to MySQL and read data from an employees table using try-catch-finally.

6 steps of JDBC:

Load the driver
Establish the connection
Create a Statement
Execute the query
Process the ResultSet
Close the resources (in finally)

Learned: private static final constants, separate methods, printf output formatting.

Day 2: try-with-resources (Day2P1.java)

Same idea with a cleaner approach on a products table. Connection, Statement, and ResultSet are closed automatically, so there is no manual finally and no resource leaks.

Learned: try-with-resources, reading columns by name or index (index starts at 1).

Day 3: CRUD part 1 (Day3.java, Day3P2.java)

Changed data in a departments table instead of only reading it. Day3.java inserts a row and Day3P2.java deletes a row.

Learned: executeUpdate() for INSERT, UPDATE, and DELETE (returns the number of rows affected), executeQuery() for SELECT, and always use WHERE with DELETE.

Day 4: PreparedStatement (Day4.java, Day4P2.java)

Took input from the user with Scanner and used ? placeholders instead of joining values into the SQL. Day4.java searches a department by name and Day4P2.java updates product prices by category.

Learned: PreparedStatement with setString() and setInt() (parameter index starts at 1), why it prevents SQL injection, handling "not found" and invalid input, and now all four CRUD operations are done ✅
