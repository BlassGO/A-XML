# 📄 AXML

**AXML** is an open-source Java command-line tool for decoding and encoding Android binary XML (AXML) files, such as `AndroidManifest.xml`.

- Built for JDK 8+

## Build

Using Gradle to build the executable JAR:

```bash
./gradlew jar
```

## Usage

1. Decode Android Binary XML to text
```bash
java -jar axml.jar -d input.xml output.xml
```

2. Encode text to Android Binary XML
```bash
java -jar axml.jar -e input.xml output.xml
```

## Credits
- [**BlassGO**](https://github.com/BlassGO): Project's updated structure
- [**codyi96**](https://github.com/codyi96): Original AXML parsing logic from [xml2axml](https://github.com/codyi96/xml2axml).