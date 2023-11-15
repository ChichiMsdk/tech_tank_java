import org.junit.jupiter.api.Test;

public class TestParserHelper{

    @Test
    public void testSplitNameValid() {
        String[] result = ParserHelper.splitName("John Doe");
        assert result != null : "Result should not be null";
        assert result.length == 2 : "Expected 2 parts, got " + result.length;
        assert "John".equals(result[0]) : "Expected 'John', got " + result[0];
        assert "Doe".equals(result[1]) : "Expected 'Doe', got " + result[1];
    }

    @Test
    public void testSplitNameWithMultipleSpaces() {
        String[] result = ParserHelper.splitName("John Middle Doe");
        assert result != null : "Result should not be null";
        assert result.length == 2 : "Expected 2 parts, got " + result.length;
        assert "John".equals(result[0]) : "Expected 'John', got " + result[0];
        assert "Doe".equals(result[1]) : "Expected 'Doe', got " + result[1];
    }

    @Test
    public void testSplitNameEmpty() {
        String[] result = ParserHelper.splitName("");
        assert result == null : "Result should be null";
    }

    @Test
    public void testSplitFieldsValid() {
        String[] result = ParserHelper.splitFields("John, Doe, 123");
        assert result != null : "Result should not be null";
        assert result.length == 3 : "Expected 3 parts, got " + result.length;
    }

    @Test
    public void testSplitFieldsInvalid() {
        String[] result = ParserHelper.splitFields("John, Doe.");
        assert result == null : "Result should be null";
    }
    @Test
    public void testSplitFieldsEmpty() {
        String[] result = ParserHelper.splitFields("");
        assert result == null : "Result should be null";
    }
}

