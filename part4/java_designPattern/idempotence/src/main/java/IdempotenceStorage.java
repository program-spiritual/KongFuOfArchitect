public interface IdempotenceStorage {
    boolean saveIfAbsent(String idempotenceId);
    void delete(String idempotenceId);
}
