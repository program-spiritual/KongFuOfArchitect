class C {
  x=0
  y=0
}

type instanceTypeT0 = InstanceType<typeof C>

const a:C[] = [{x:12,y:23}]

type instanceTypeT1 = InstanceType<any>

type instanceTypeT2 = InstanceType<never>

