package io.github.bluething.solid.kata.globalmanticshr.documents;

public class WorkContract implements ExportableText, ExportableJson, ExportablePdf {
    private final String content;

    public WorkContract(String content) {
        this.content = content;
    }

    @Override
    public String toJson() {
        return "{'content':'" + this.content + "'}";
    }

    @Override
    public byte[] toPdf() {
        return content.getBytes();
    }

    @Override
    public String toTxt() {
        return this.content;
    }
}
