package eu.irian.example.cdi;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

@SessionScoped
@Named
public class SessionInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  private static final Random RANDOM = new Random(System.currentTimeMillis());

  private Integer counter = 0;

  private final Integer objectId = Math.abs(RANDOM.nextInt()) % 1000;

  public SessionInfo() {
    System.out.println("Constructor of SessionInfo");
  }

  public void increaseCounter() {
    System.out.println("increaseCounter");
    setCounter(counter + 1);
  }

  public Integer getObjectId() {
    return objectId;
  }

  public Integer getCounter() {
    increaseCounter();
    return counter;
  }

  public void setCounter(Integer counter) {
    this.counter = counter;
  }

  public Integer getIdentityHashCode() {
    return System.identityHashCode(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionInfo that = (SessionInfo) o;
    return Objects.equals(counter, that.counter)
        && Objects.equals(objectId,
        that.objectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(counter, objectId);
  }

  @Override
  public String toString() {
    return String.format("SessionInfo{counter=%d, objectId=%d}", counter, objectId);
  }
}
