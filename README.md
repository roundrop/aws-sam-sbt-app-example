# aws-sam-sbt-app-example

Scala sbt multi-project example of AWS lambda function with SAM.

## build

```
$ sbt "project lambda1" assembly
$ sbt "project lambda2" assembly
```

## Invoke Lambda Function

### via sam command

```
$ sam local invoke "Lambda1Function"
```

### via scalatest

```
$ sbt "testOnly lambda1.HandlerSpec"
```

## packaginbg and deployment
TODO
