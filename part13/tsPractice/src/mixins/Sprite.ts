class Sprite {
  name = ""
  x = 0
  y = 0

  constructor(name) {
    this.name = name
  }
}

type Constructor = new(...args: any[]) => {}

class TBase {
}
function Scale<TBase extends Constructor>(Base:TBase) {
  return class Scaling extends Base{
    private _scale=1;

    get scale(): number {
      return this._scale;
    }

    set scale(number: number) {
      this._scale = number;
    }

    setScale(number: number) {
      this._scale = number;
    }
  }
}

const EightBitSprite = Scale(Sprite);

const flappySprite = new EightBitSprite("Bird");
flappySprite.setScale(0.8);
console.log(flappySprite.scale);


