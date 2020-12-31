# SQL Practice

Table of Contents
-----------------

* [175. Combine Two Tables](#175-combine-two-tables)
* [181. Employees Earning More Than Their Managers](#181-employees-earning-more-than-their-managers)
* [182. Duplicate Emails](#182-duplicate-emails)
* [183. Customers Who Never Order](#183-customers-who-never-order)
* [595. Big Countries](#595-big-countries)
* [596. Classes More Than 5 Students](#596-classes-more-than-5-students)
* [620. Not Boring Movies](#620-not-boring-movies)



## 175. Combine Two Tables

**Description**

Table: `Person`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
```

Table: `Address`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.
```

 

Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

```
FirstName, LastName, City, State
```



**Solution**

```mysql
SELECT 
    FirstName, 
    LastName, 
    City, 
    State
FROM 
    Person P
    LEFT JOIN Address A
    ON P.PersonId = A.PersonId;
```





## 181. Employees Earning More Than Their Managers

**Description**

The `Employee` table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

```
+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
```

Write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

**Solution**

```mysql
SELECT
    E1.Name AS Employee
FROM
    Employee E1
    INNER JOIN Employee E2
    ON E1.ManagerId = E2.Id
WHERE
    E1.Salary > E2.Salary;
```



## 182. Duplicate Emails

**Description**

Write a SQL query to find all duplicate emails in a table named `Person`.

```
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
```



**Solution**

```mysql
SELECT
    Email
FROM
    Person
GROUP BY
    Email
HAVING 
    COUNT(Email) > 1;
```



## 183. Customers Who Never Order

**Description**

Suppose that a website contains two tables, the `Customers` table and the `Orders` table. Write a SQL query to find all customers who never order anything.

Table: `Customers`.

```
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
```

Table: `Orders`.

```
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
```

**Explained**

<div align="center"> <img src="sql-joins.png" width="70%"/> </div><br>

**Solution**

```mysql
SELECT
    Name AS Customers
FROM
    Customers C
    LEFT JOIN Orders O
    ON C.Id = O.CustomerId
WHERE
    O.CustomerId IS NULL;
```



## 595. Big Countries

**Description**

There is a table `World`

```
+-----------------+------------+------------+--------------+---------------+
| name            | continent  | area       | population   | gdp           |
+-----------------+------------+------------+--------------+---------------+
| Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |
| Albania         | Europe     | 28748      | 2831741      | 12960000      |
| Algeria         | Africa     | 2381741    | 37100000     | 188681000     |
| Andorra         | Europe     | 468        | 78115        | 3712000       |
| Angola          | Africa     | 1246700    | 20609294     | 100990000     |
+-----------------+------------+------------+--------------+---------------+
```

A country is big if it has an area of bigger than 3 million square km or a population of more than 25 million.

Write a SQL solution to output big countries' name, population and area.



**Solution**

```mysql
SELECT 
    name, population, area
FROM 
    World
WHERE
     area > 3000000
     OR population > 25000000;
```



## 596. Classes More Than 5 Students

**Description**

There is a table `courses` with columns: **student** and **class**

Please list out all classes which have more than or equal to 5 students.


The students should not be counted duplicate in each course.



**Explained**

<div align="center"> <img src="image-20201230234652696.png" width="80%"/> </div><br>




**Solution**

```mysql
SELECT 
    class
FROM
    courses
GROUP BY
    class
HAVING
    COUNT(DISTINCT student) >= 5;
```





## 620. Not Boring Movies

**Description**

X city opened a new cinema, many people would like to go to this cinema. The cinema also gives out a poster indicating the movies’ ratings and descriptions.

Please write a SQL query to output movies with an odd numbered ID and a description that is not 'boring'. Order the result by rating. 



**Solution**

```mysql
SELECT
    *
FROM
    cinema
WHERE
    id % 2 = 1
    AND description <> 'boring'
ORDER BY
    rating DESC;
```





