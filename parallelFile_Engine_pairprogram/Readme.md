flow of the parallel file Engine

Main → SearchEngineService → FileLoader → ExecutorService → FileSearchTask → ResultCollector → ReportGenerator


Step-by-step flow:

#### Main.java

Takes directory path, keyword, thread count from user.

Calls SearchEngineService.search().

#### SearchEngineService :

Validates directory

Loads files using FileLoader

Creates thread pool

Submits a FileSearchTask for each file

Waits for all threads to finish

Calls ReportGenerator to print summary

#### FileLoader :

Recursively scans folders

Filters only text/log/code files

Returns list of files

#### FileSearchTask (Runnable) :

Each thread reads one file

Counts occurrences of keyword

On success → collector.addResult()

On error → collector.addError() and logs

#### ResultCollector:

Stores results in thread-safe collections

Stores errors found during search

#### ReportGenerator:

Prints final summarized results


## Solid principles

| Class                          | Single Responsibility                           |
| ------------------------------ | ----------------------------------------------- |
| `FileLoader`                   | Only loads files (directory scanning).          |
| `FileSearchTask`               | Only searches within a single file.             |
| `ResultCollector`              | Only collects results & errors.                 |
| `SearchLogger`                 | Only handles logging.                           |
| `ReportGenerator`              | Only prints summary report.                     |
| `SearchEngineService`          | Controls workflow (executor + task submission). |
| `SearchError` / `SearchResult` | Pure model classes (data containers).           |

O — Open/Closed Principle (OCP)

Classes should be open for extension, but closed for modification.

L — Liskov Substitution Principle (LSP)

Subclasses should be replaceable with base classes.

use:

Runnable

Exception (custom exceptions extend it)


I — Interface Segregation Principle (ISP)

Clients should not depend on methods they do not use.

I implement Runnable for file search tasks:

public class FileSearchTask implements Runnable { ... }


This gives only one required method (run()), which is perfect.

 No unnecessary methods
 No forced interfaces


D — Dependency Injection / Inversion Principle (DIP)

High-level modules should not depend on low-level modules directly.

I apply DIP by passing dependencies into constructors, not creating them:

Example:

public FileSearchTask(Path file, String keyword, ResultCollector collector)


Here:

FileSearchTask does not create ResultCollector

SearchEngineService injects it