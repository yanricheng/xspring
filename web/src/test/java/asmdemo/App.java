package asmdemo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
 
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
 
public class App extends ClassLoader implements Opcodes {
public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, InstantiationException {
ClassReader cr=new ClassReader(HelloWorld.class.getName());
ClassWriter cw=new ClassWriter(ClassWriter.COMPUTE_MAXS);
CustomVisitor myv=new CustomVisitor(Opcodes.ASM4,cw);
cr.accept(myv, 0);
byte[] code=cw.toByteArray();
//自定义加载器
App loader=new App();
Class<?> appClass=loader.defineClass(null, code, 0,code.length);
appClass.getMethods()[0].invoke(appClass.newInstance(), new Object[]{});
//	FileOutputStream f=new FileOutputStream(new File("d:"+File.separator+"ok2.class"));
//	f.write(code);;
//	f.close();
}
}
