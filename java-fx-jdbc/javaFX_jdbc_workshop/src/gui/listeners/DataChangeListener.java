package gui.listeners;

public interface DataChangeListener {

    // It's an event to be fired when data changes.
    // This way we can automatically update the table when saving a new object.

    // 'subject' emits event:
    // 'private List<DataChangeListener> dataChangeListeners = new ArrayList<>();' in 'DepartmentFormController'
    // The List above will store objects interested in receiving an event.

    // 'observer' receives event:
    // it subscribes to the event, and then when event is emitted, the respective method is executed
    // in 'DepartmentListController'
    void onDataChanged();
}
