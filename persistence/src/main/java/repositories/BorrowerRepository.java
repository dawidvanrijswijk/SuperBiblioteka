package repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javakrk9.exceptions.BorrowerNotFoundException;
import javakrk9.models.Borrower;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BorrowerRepository implements IBorrowerRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String BORROWER_DB_PATH = "./persistence/src/main/resources/database/borrowers.json";

    public void create(Borrower borrower) throws IOException {
        List<Borrower> borrowers = getAll(true);
        if (borrowers.size() > 0) {
            borrower.setId(findMaxBorrowerID(borrowers) + 1);
        } else {
            borrowers = new ArrayList<>();
            borrower.setId(1L);
        }
        borrowers.add(borrower);
        OBJECT_MAPPER.writeValue(new File(BORROWER_DB_PATH), borrowers);
    }

    private Long findMaxBorrowerID(List<Borrower> borrowers) {
        return borrowers.stream().max(Comparator.comparing(Borrower::getId)).get().getId();
    }

    public void delete(Long borrowerID) throws IOException {
        List<Borrower> borrowers = getAll(true).stream().filter(x -> x.getId().equals(borrowerID)).collect(Collectors.toList());
        if (borrowers.size() < 1) return;
        borrowers.forEach(x -> x.setDeleted(true));
        OBJECT_MAPPER.writeValue(new File(BORROWER_DB_PATH), borrowers);
    }

    public List<Borrower> getAll() throws IOException {
        return getAll(false);
    }

    public Borrower get(Long borrowerID) throws IOException, BorrowerNotFoundException {
        List<Borrower> borrowers = getAll(false);
        Optional<Borrower> borrowerOpt = borrowers.stream().filter(x -> x.getId().equals(borrowerID)).findFirst();

        if (!borrowerOpt.isPresent())
            throw new BorrowerNotFoundException("Nie znaleziono książki o id = " + borrowerID);
        else
            return borrowerOpt.get();
    }

    public void update(Borrower borrower, Long borrowerID) throws IOException, BorrowerNotFoundException {
        List<Borrower> borrowers = getAll(false);

        Optional<Borrower> borrowerOpt = borrowers.stream().filter(x -> x.getId().equals(borrowerID)).findFirst();

        if (!borrowerOpt.isPresent())
            throw new BorrowerNotFoundException("Nie znaleziono książki o id = " + borrowerID);
        else {
            Borrower borrowerFromDB = borrowers.stream().filter(x -> x.getId().equals(borrowerID)).findFirst().get();
            updateValues(borrowerFromDB, borrower);

            OBJECT_MAPPER.writeValue(new File(BORROWER_DB_PATH), borrowers);
        }
    }

    private void updateValues(Borrower borrowerToBeOverwritten, Borrower borrowerToOverwrite) {
        borrowerToBeOverwritten.setName(borrowerToOverwrite.getName());
        borrowerToBeOverwritten.setSurname(borrowerToOverwrite.getSurname());
        borrowerToBeOverwritten.setAddress(borrowerToOverwrite.getAddress());
        borrowerToBeOverwritten.setPhoneNumber(borrowerToOverwrite.getPhoneNumber());
        borrowerToBeOverwritten.setEmail(borrowerToOverwrite.getEmail());
        borrowerToBeOverwritten.setDeleted(borrowerToOverwrite.isDeleted());
    }

    private List<Borrower> getAll(boolean getAllWithDeleted) throws IOException {
        List<Borrower> borrowers = OBJECT_MAPPER.readValue(new File(BORROWER_DB_PATH), new TypeReference<List<Borrower>>() {
        });
        if (getAllWithDeleted)
            return borrowers;
        else
            return borrowers.stream().filter(x -> !x.isDeleted()).collect(Collectors.toList());
    }
}