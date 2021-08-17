package io.github.bluething.solid.kata.globalmanticshr.documents;

public class PaySlip implements ExportableDocument {
    @Override
    public byte[] toPdf() {
        return new byte[0];
    }

    @Override
    public String toJson() {
        return null;
    }

    @Override
    public String toTxt() {
        return null;
    }
}
