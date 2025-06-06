# File System with Search Filters

This project simulates a hierarchical file system with support for **files**, **folders**, and powerful **search filters**. It is designed using **Object-Oriented Principles** and the **Composite** and **Strategy** design patterns to ensure flexibility and extensibility.

---

## 🧱 Components

### ✅ File System Structure
- **`FileSystemEntity`** (abstract): Base class for all file system elements.
- **`File`**: Represents a file with an extension.
- **`Folder`**: Can contain multiple files or subfolders (not shown in the code but assumed similar to `File`).

### ✅ Search Filters
- All filters implement the `Filter` interface:
  - `SearchByTitleFilter`: Matches entities based on title (case-insensitive `contains`).
  - `SearchByFileExtensionFilter`: Matches files with a specific extension.
  - `AndFilter`: Matches if **all** child filters match (logical AND).
  - `OrFilter`: Matches if **any** child filter matches (logical OR).

---

## 💡 Design Patterns Used

### 1. **Composite Pattern**
- The file system (`File`, `Folder`) is modeled as a tree structure.
- `FileSystemEntity` acts as the common base, allowing uniform treatment of files and folders during traversal or filtering.

### 2. **Strategy Pattern**
- Filters encapsulate different filtering strategies and are interchangeable at runtime.
- Clients can combine strategies using `AndFilter` or `OrFilter`, enabling complex search logic.

---

## 🔍 Features

- Recursively traverses folder hierarchy using DFS.
- Performs filtered searches using:
  - **Single criteria** (e.g., title or extension).
  - **Multiple criteria with AND logic**.
  - **Multiple criteria with OR logic**.
- Case-insensitive title matching.
- Easy to add new filter types without changing existing code.

---

## 🔧 Extensibility

This system is designed to be **easily extensible**:
- ✅ Add new types of filters by simply implementing the `Filter` interface (e.g., `SizeFilter`, `CreatedDateFilter`).
- ✅ Combine any number of filters using `AndFilter` or `OrFilter`.
- ✅ Support more logical operations in the future (e.g., `NotFilter`).
- ✅ Add more metadata fields to `File` or `Folder` and create corresponding filters.

---

## 🚀 Example Usage

```java
Filter titleFilter = new SearchByTitleFilter("file");
Filter extFilter = new SearchByFileExtensionFilter("pdf");

Filter andFilter = new AndFilter(titleFilter, extFilter);
Filter orFilter = new OrFilter(titleFilter, extFilter);
````

---

## 📂 Sample Output

```
File entities matched by title 'file'[Text-File-inside-root.txt, PDF-File-inside-subfolder.pdf, PDF-File2-inside-subfolder.pdf, file.txt, file.pdf]
File entities matched by file extension '.pdf'[PDF-File-inside-subfolder.pdf, PDF-File2-inside-subfolder.pdf, file.pdf]
File entities matched by title 'file' and file extension '.pdf'[PDF-File-inside-subfolder.pdf, PDF-File2-inside-subfolder.pdf, file.pdf]
File entities matched by title 'file' or file extension '.pdf'[Text-File-inside-root.txt, PDF-File-inside-subfolder.pdf, PDF-File2-inside-subfolder.pdf, file.txt, file.pdf]
```

---

## 📁 Folder Structure

```
src/
├── file/
│   ├── entity/
│   │   ├── File.java
│   │   ├── Folder.java 
│   │   └── FileSystemEntity.java
│   └── filter/
│       ├── Filter.java
│       └── impl/
│           ├── SearchByTitleFilter.java
│           ├── SearchByFileExtensionFilter.java
│           ├── AndFilter.java
│           └── OrFilter.java
└── Main.java
```

---

## ✅ Future Improvements

* Add `NotFilter` for logical negation.
* Add `CreatedDateFilter` or `SizeFilter`.
* Implement a CLI or GUI to allow users to interactively build and run filters.

---

## 🧠 Author Notes

Designed to demonstrate real-world application of design patterns like **Composite** and **Strategy**, while keeping the code clean, modular, and open to extension (Open/Closed Principle).

