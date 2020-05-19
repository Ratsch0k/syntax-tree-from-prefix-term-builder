# Build a syntax tree from a term in prefix notation

## How to run

### Windows
Use the command
```
gradlew.bat run --args '"<term>"'
```
in the command line and replace <term> with you actual prefix term.

Example:
```
gradlew.bat run --args '"+ * + 1 + 2 3 7 * 4 5"'
```

which results in the output
```json
{
  "value": "+",
  "leftChild": {
    "value": "*",
    "leftChild": {
      "value": "+",
      "leftChild": {
        "value": "1"
      },
      "rightChild": {
        "value": "+",
        "leftChild": {
          "value": "2"
        },
        "rightChild": {
          "value": "3"
        }
      }
    },
    "rightChild": {
      "value": "7"
    }
  },
  "rightChild": {
    "value": "*",
    "leftChild": {
      "value": "4"
    },
    "rightChild": {
      "value": "5"
    }
  }
}
```

Licensed under MIT
