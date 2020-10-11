package ru.vtb.hakaton.cars.exception;

import java.util.UUID;

public class EntityNotFoundException extends CarServiceException {

    private static final long serialVersionUID = 5572380128132866720L;

    public EntityNotFoundException(UUID uuid) {
        super("Entity with uuid '" + uuid.toString() + "' not found.");
    }
}
