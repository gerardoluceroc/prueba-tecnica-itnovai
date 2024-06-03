variable "token_digitalocean" {
  description = "Token to connect to your DigitalOcean account"
  type    = string
  default = "dop_v1_ef87bef4666b60cf8c2e81e65859dabd805228795e7b05f685bc534e96ae8db9"
}

variable "fingerprint_ssh_key_digitalocean" {
  description = "Fingerprint of the saved SSH key associated with your DigitalOcean account"
  type    = string
  default = "ea:bc:26:fe:8e:8b:c3:c0:50:41:f1:be:af:13:ae:a6"
}

variable "droplet_image" {
  description = "Image of the droplet to be created."
  type    = string
  default = "ubuntu-22-04-x64"
}

variable "droplet_name" {
  description = "Name of the droplet to be created."
  type    = string
  default = "ItnovAI-Server"
}

variable "droplet_region" {
  description = "Region of the droplet to be created."
  type    = string
  default = "nyc1"
}


variable "droplet_size" {
  description = "Region of the droplet to be created."
  type    = string
  default = "s-1vcpu-1gb"
}
