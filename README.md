# 🗄️ Java JDBC with MySQL

Learning how Java connects to a database using JDBC, one day at a time. 🚀

---

## Day 1: JDBC basics (`Day2.java`)

Connected Java to MySQL and read data from an `employees` table using `try-catch-finally`.

**6 steps of JDBC:**
1. Load the driver
2. Establish the connection
3. Create a `Statement`
4. Execute the query
5. Process the `ResultSet`
6. Close the resources (in `finally`)

**Learned:** `private static final` constants, separate methods, `printf` output formatting.

---

## Day 2: try-with-resources (`Day2P1.java`)

Same idea with a cleaner approach on a `products` table. Connection, `Statement`, and `ResultSet` are **closed automatically**, so there is no manual `finally` and no resource leaks.

**Learned:** `try-with-resources`, reading columns by name or index (index starts at **1**).

---

