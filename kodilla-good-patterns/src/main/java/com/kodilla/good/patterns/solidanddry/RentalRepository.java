package com.kodilla.good.patterns.solidanddry;

import java.time.LocalDateTime;

public interface RentalRepository {


   boolean createRental(User user, LocalDateTime date, LocalDateTime dateTo);

}
