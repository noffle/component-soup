package net.sww.ecs;

public abstract class Component {

    // TODO(sww): make this private
    public Entity entity;

    void installed(Entity entity) {
        this.entity = entity;
        init();
    }
    void uninstalled(Entity entity) {
        this.entity = null;
    }
    public void update(float dt) {}
    public void lateUpdate(float dt) {}
    public void onEvent(Event msg) {}
    public void init() {}

    public final <T extends Component> T get(Class<T> type) {
        return entity.get(type);
    }

    public final <T extends Component> boolean has(Class<T> type) {
        return entity.has(type);
    }

    public final World getWorld() {
        return entity.world;
    }

    public final Entity getEntity() {
        return entity;
    }

    public final void sendEvent(Event event) {
        entity.sendEvent(event);
    }

    public final void broadcastEvent(Event event) {
        entity.broadcastEvent(event);
    }
}
