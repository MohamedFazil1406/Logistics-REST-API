resource "aws_instance" "logistics_server" {
  ami           = "ami-0f918f7e67a3323f0"
  instance_type = "t2.micro"

  tags = {
    Name = "logistics-server"
  }
}


resource "aws_db_instance" "logistics_db" {
  allocated_storage    = 20
  engine               = "mysql"
  engine_version       = "8.0"
  instance_class       = "db.t3.micro"

  db_name  = "logistics"
  username = "admin"
  password = "root12345"

  skip_final_snapshot = true
}