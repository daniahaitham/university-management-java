# University Management System (Java)

A console application that manages university data (departments, employees, student counselling and student performance) and answers queries about it. Built for the Advanced Programming course to practise **object-oriented design, SOLID principles and unit testing**.

## What it does

- Look up a department, employee, student's counselling record or student's performance by ID
- List employees or students in a department
- Find students by admission-date range or birth-date range
- Statistics: number of employees in a department, number of students in a department, and a student's number of semesters, papers, total, average, maximum and minimum marks

The data is read from pipe-separated text files (about 209,000 performance records, 4,000 students, 1,000 employees and 40 departments).

## Design

| Concept | Where |
|---|---|
| **Inheritance** | `Department` and `Employee` extend `EmpDept` (shared department ID) |
| **Interface segregation** | Small interfaces instead of one large one: `infoRetrieval`, `StatisticalOperation`, `InfoProviderByDeptName`, `OperationsOnMarks`. Each class implements only what it needs |
| **Single responsibility** | `readingFiles` only loads files; each entity class only answers queries about its own data; `managemantSystem` only handles the menu |
| **Unit tests** | JUnit 5 tests for the employee and student-performance statistics |

## Project structure

```
src/main/java/finalAdvancedProgramming/   application code
src/test/java/finalAdvancedProgramming/   JUnit 5 tests
data/                                     put the dataset here (not included)
pom.xml                                   Maven build
```

## Data

The dataset is public on Kaggle and is not included in this repository. See [`data/README.md`](data/README.md) for the link and the four files to place in `data/`.

## Run it

Requires JDK 17+ and Maven.

```bash
mvn test                                    # run the unit tests
mvn compile exec:java -Dexec.mainClass=finalAdvancedProgramming.managemantSystem
```

Or without Maven:

```bash
javac -d out src/main/java/finalAdvancedProgramming/*.java
java -cp out finalAdvancedProgramming.managemantSystem
```

Run from the project root so the program finds the `data/` folder.

## Example

```
Welcome in Uni-System, press the suitable num:
2            (employees)
2            (employee numbers in a department)
IDEPT5109    -> 42
```

## What I learned

- Splitting behaviour into small interfaces so classes depend only on what they use
- Writing unit tests that check results against the data
- Reading and processing a large flat-file dataset in Java
- Handling bad console input without crashing
