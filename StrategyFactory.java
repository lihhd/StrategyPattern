@Component
public class StrategyFactory implements InitializingBean, ApplicationContextAware {
  private static final Map<String, Handler<Serializable>> HANDLER_MAP = new HashMap<>(8);
  private ApplicationContext appContext;
  /**
   * 根据提交类型获取对应的处理器
   *
   * @param submitType 提交类型
   * @return 提交类型对应的处理器
   */
  public Handler<Serializable> getHandler(String type) {
    return HANDLER_MAP.get(type); 
  }
  @Override
  public void afterPropertiesSet() {
    // 将 Spring 容器中所有的 Handler 注册到 HANDLER_MAP
    appContext.getBeansOfType(Handler.class).values().forEach(handler -> HANDLER_MAP.put(handler.getType(), handler));
  }
  @Override
  public void setApplicationContext(@NonNull ApplicationContext applicationContext) { 
    appContext = applicationContext;
  }
}
