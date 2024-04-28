import { View, Text } from '@tarojs/components'
import { useLoad } from '@tarojs/taro'
import { useState } from "react"
import axios from '@axios'
import './index.scss'
import {REQUEST_URL} from ENV;

export default function Index() {
  
  const [resturantList, setResturantList] = useState([]);


  useLoad(async () => {
    query(1);
  })

  function query(pageIndex){
    const list = axios.post(REQUEST_URL, "getAllResturant", {
      pageIndex,
      pageNum: 100
    })

    if(list?.length){
      setResturantList(list);
    }
  }

  function Resturant(info){

    const {
      name = '',
      foodItems = '',
      address = ''
    } = info;

    function goDetail(data){
      location.href = data.href;
    }

    return (
      <View className='resturant' onClick={goDetail}>
        <View className='name'>{name}</View>
        <View className='food-items'>{foodItems.splig(":")}</View>
        <View className='address'>address</View>
      </View>
    )
  }

  return (
    <View className='index'>
      <View className="title">餐厅推荐</View>
      <View className="resturant_list">
        {
          resturantList.map(item=>{
            return <Resturant info = {item}></Resturant>
          })
        }

      </View>
    </View>
  )
}
