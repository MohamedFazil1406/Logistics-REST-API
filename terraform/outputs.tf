output "public_ip" {
  value = aws_instance.logistics_server.public_ip
}

output "rds_endpoint" {
  value = aws_db_instance.logistics_db.address
}