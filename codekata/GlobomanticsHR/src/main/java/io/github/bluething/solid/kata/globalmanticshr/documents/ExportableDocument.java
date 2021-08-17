package io.github.bluething.solid.kata.globalmanticshr.documents;

public interface ExportableDocument {
    byte[] toPdf();
    String toJson();
    String toTxt();
}
