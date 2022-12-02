package fc;

class MachineFacade {
    private static MachineFacade machineFacade;

    private MachineFacade() {
        // nothing to init
    }

    static MachineFacade getInstance() {
        if (machineFacade == null) {
            machineFacade = new MachineFacade();
        }
        return machineFacade;
    }

    /* Facade with the mechanical arm */

    /**
     * Place the disc from the disc drive to the given position in the machine.
     */
    void insertDiscAtPosition(int position) {

    }

    /**
     * Place the disc from given position in the machine to the disc drive.
     */
    void extractDiscFromPosition(int position) {

    }

    /* Facade with the disc drive */

    /**
     * Check if the disc drive currently contains a disc.
     *
     * @return {@code true} is the disc drive is empty and {@code false} otherwise
     */
    boolean isDiscDriveEmpty() {
        return true;
    }

    /**
     * Read the contents of the disc drive.
     *
     * @return a disc serial number or -1 if the disc is not readable
     * @throws IllegalArgumentException if there is no disc in the disc drive
     */
    int readDisc() throws IllegalStateException {
        if (isDiscDriveEmpty()) {
            throw new IllegalStateException("Impossible to read the disc drive: no disc in");
        }
        return -1;
    }

    /**
     * Eject the disc from the disc drive out of the machine.
     *
     * @throws IllegalStateException if there is no disc in the disc drive
     */
    void ejectDisc() throws IllegalStateException {
        if (isDiscDriveEmpty()) {
            throw new IllegalStateException("Impossible to eject from the disc drive: no disc in");
        }
    }

    /* Facade with the card readers */

    /**
     * Read the contents of credit card reader.
     *
     * @return a credit card number or -1 if there is no card in the reader
     */
    int readCreditCard() {
        return -1;
    }

    /**
     * Read the contents of the subscription card reader.
     *
     * @return a subscription card number or -1 if there is no card in the reader
     */
    int readSubscriptionCard() {
        return -1;
    }

    /* Facade with the bank */

    /**
     * Check if the bank validate the payment.
     *
     * @param creditCardNumber the credit card number of the user making the payment
     * @param amount           the payment amount
     * @return {@code true} if the bank validates the payment and {@code false} otherwise
     */
    boolean isValidPayment(int creditCardNumber, int amount) {
        return true;
    }
}
