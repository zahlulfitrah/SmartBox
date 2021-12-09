public class Items implements Strategy {
    public String items[] = { "Emas", "Uang", "Berlian", "Hard Disk" };

    @Override
    public Iterator getAdapter() {
        return new ItemsIterate();
    }

    private class ItemsIterate implements Adapter {
        int i;

        @Override
        public boolean hasNext() {
            if (i < items.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return items[i++];
            }
            return null;
        }
    }
}