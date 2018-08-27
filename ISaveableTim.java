package masterclass;

import java.util.List;

public interface ISaveableTim {
    List<String> write();
    void read(List<String> savedValues);
}
