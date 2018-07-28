package repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javakrk9.exceptions.BorrowNotFoundException;
import javakrk9.models.Borrow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BorrowRepository implements IBorrowRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String BORROW_DB_PATH = "./persistence/src/main/resources/database/borrows.json";

    public BorrowRepository() {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public void create(Borrow borrow) throws IOException {
        List<Borrow> borrows = getAll(true);
        if (borrows.size() > 0) {
            borrow.setBorrowId(findMaxBorrowID(borrows) + 1);
        } else {
            borrows = new ArrayList<>();
            borrow.setBorrowId(1L);
        }
        borrows.add(borrow);
        OBJECT_MAPPER.writeValue(new File(BORROW_DB_PATH), borrows);
    }

    private Long findMaxBorrowID(List<Borrow> borrows) {
        return borrows.stream().max(Comparator.comparing(Borrow::getBorrowId)).get().getBorrowId();
    }

    public void returnBook(Long borrowID) throws IOException {
        List<Borrow> borrows = getAll(true).stream().filter(x -> x.getBorrowId().equals(borrowID)).collect(Collectors.toList());
        if (borrows.size() < 1) return;
        borrows.forEach(x -> x.setReturned(true));
        OBJECT_MAPPER.writeValue(new File(BORROW_DB_PATH), borrows);
    }

    public List<Borrow> getAll() throws IOException {
        return getAll(false);
    }

    public Borrow get(Long borrowID) throws IOException, BorrowNotFoundException {
        List<Borrow> borrows = getAll(false);
        Optional<Borrow> borrowOpt = borrows.stream().filter(x -> x.getBorrowId().equals(borrowID)).findFirst();

        if (!borrowOpt.isPresent())
            throw new BorrowNotFoundException("Nie znaleziono książki o id = " + borrowID);
        else
            return borrowOpt.get();
    }

    public void update(Borrow borrow, Long borrowID) throws IOException, BorrowNotFoundException {
        List<Borrow> borrows = getAll(false);

        Optional<Borrow> borrowOpt = borrows.stream().filter(x -> x.getBorrowId().equals(borrowID)).findFirst();

        if (!borrowOpt.isPresent())
            throw new BorrowNotFoundException("Nie znaleziono książki o id = " + borrowID);
        else {
            Borrow borrowFromDB = borrows.stream().filter(x -> x.getBorrowId().equals(borrowID)).findFirst().get();
            updateValues(borrowFromDB, borrow);

            OBJECT_MAPPER.writeValue(new File(BORROW_DB_PATH), borrows);
        }
    }

    private void updateValues(Borrow borrowToBeOverwritten, Borrow borrowToOverwrite) {
        borrowToBeOverwritten.setBorrowDate(borrowToOverwrite.getBorrowDate());
        borrowToBeOverwritten.setBookId(borrowToOverwrite.getBookId());
        borrowToBeOverwritten.setBorrowerId(borrowToOverwrite.getBorrowerId());
        borrowToBeOverwritten.setReturned(borrowToOverwrite.isReturned());
    }

    private List<Borrow> getAll(boolean getAllWithDeleted) throws IOException {
        List<Borrow> borrows = OBJECT_MAPPER.readValue(new File(BORROW_DB_PATH), new TypeReference<List<Borrow>>() {
        });
        if (getAllWithDeleted)
            return borrows;
        else
            return borrows.stream().filter(x -> !x.isReturned()).collect(Collectors.toList());
    }
}