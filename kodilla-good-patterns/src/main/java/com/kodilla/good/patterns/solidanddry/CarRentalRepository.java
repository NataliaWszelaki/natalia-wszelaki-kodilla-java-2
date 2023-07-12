package com.kodilla.good.patterns.solidanddry;

import java.time.LocalDateTime;

public class CarRentalRepository implements RentalRepository {
    @Override
    public boolean createRental(User user, LocalDateTime date, LocalDateTime dateTo) {
    return true;
    }
}
