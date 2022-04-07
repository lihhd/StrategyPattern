@Service
public class ServiceImpl implements Service { 
  @Autowired
  private HandlerFactory handlerFactory;
  public CommonPair<String, Serializable> test1(@NonNull Request request) {
    String type = request.getType();
    // 根据 type 找到对应的提交处理器
    Handler<Serializable> handler = handlerFactory.getHandler(type);
    // 判断 type 对应的 handler 是否存在
    if (handler == null) {
      return CommonPair.failure("非法的提交类型: " + type);
    }
    // 处理提交
    return handler.handle(request); 
  }
}
