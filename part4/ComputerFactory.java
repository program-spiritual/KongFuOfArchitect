class Computer {

  private CPU cpu;
  private Memory memory;
  private HardDisk hardDisk;
  private MainBoard mainBoard;
  // constructor
  public Computer(CPU cpu, Memory memory, HardDisk hardDisk, MainBoard mainBoard) {
    this.cpu = cpu;
    this.memory = memory;
    this.hardDisk = hardDisk;
    this.mainBoard = mainBoard;
  }

    public static void main(String[] args) {
    ComputerFactory computerFactory = new IntelComputerFactory();
    CPU cpu = computerFactory.makeCPU();
    cpu.calculate();
    computerFactory = new AMDComputerFactory();
    cpu = computerFactory.makeCPU();
    cpu.calculate();

  }
}

class MainBoard {
  public void save() {
    System.out.println("save hard disk");
  }
}

class HardDisk {
  public void save(){
    System.out.println("save hard disk");
  }
}

class Memory {
  public void load() {
    System.out.println("load memory");
  }
}


abstract class CPU {
  public abstract void calculate();
}

class IntelCpu extends CPU{
  @Override
  public void calculate() {
    System.out.println("intel cpu");
  }
}

class AMDCpu extends CPU{
  @Override
  public void calculate() {
    System.out.println("amd cpu");
  }
}

abstract class ComputerFactory {
 // 声明为抽象方法，具体实现由子类完成
 public abstract CPU makeCPU();
  public abstract Memory makeMemory() ;
  public abstract HardDisk makeHardDisk() ;
  public abstract MainBoard makeMainBoard() ;

}

class IntelMemory extends Memory {
  @Override
  public void load() {
    System.out.println("intel memory");
  }
}

class IntelHardDisk extends HardDisk {
  @Override
  public void save() {
    System.out.println("intel hard disk");
  }
}

class IntelMainBoard extends MainBoard {
  @Override
  public void save() {
    System.out.println("intel main board");
  }
}

class IntelComputerFactory extends ComputerFactory {
  @Override
  public CPU makeCPU() {
    return new IntelCpu();
  }
  @Override
  public Memory makeMemory() {
    return new IntelMemory();
  }
  @Override
  public HardDisk makeHardDisk() {
    return new IntelHardDisk();
  }
  @Override
  public MainBoard makeMainBoard() {
    return new IntelMainBoard();
  }
}

class AMDMemory extends Memory {
  @Override
  public void load() {
    System.out.println("amd memory");
  }
}

class AMDHardDisk extends HardDisk {
  @Override
  public void save() {
    System.out.println("amd hard disk");
  }
}

class AMDMainBoard extends MainBoard {
  @Override
  public void save() {
    System.out.println("amd main board");
  }
}

class AMDComputerFactory extends ComputerFactory {
  @Override
  public CPU makeCPU() {
    return new AMDCpu();
  }
  @Override
  public Memory makeMemory() {
    return new AMDMemory();
  }
  @Override
  public HardDisk makeHardDisk() {
    return new AMDHardDisk();
  }
  @Override
  public MainBoard makeMainBoard() {
    return new AMDMainBoard();
  }
}


