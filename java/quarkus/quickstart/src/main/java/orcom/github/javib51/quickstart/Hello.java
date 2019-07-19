package orcom.github.javib51.quickstart;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;

@RegisterForReflection
public class Hello {
    private String message;

    public Hello(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Hello)) {
            return false;
        }

        Hello other = (Hello) obj;

        return Objects.equals(other.message, this.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.message);
    }
}